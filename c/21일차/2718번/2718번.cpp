#include <iostream>
#include <string>
#include <sstream>
#include <vector>
#include <array>
#include <stack>
#include <queue>
#include <map>
#include <algorithm>
#include <numeric>
#include <cmath>

class WallCol
{
private:
	long long arr[2][2][2][2] = { { { {-1,-1}, { -1,-1 } }, { {-1,-1}, { -1,-1 } } }, { { {-1,-1}, { -1,-1 } }, { {-1,-1}, { -1,-1 } } } };
public:
	long long getArr(int32_t index1, int32_t index2, int32_t index3, int32_t index4)
	{
		return arr[index1][index2][index3][index4];
	}
	void setArr(const int32_t index1, const int32_t index2, const int32_t index3, const int32_t index4, const long long val)
	{
		arr[index1][index2][index3][index4] = val;
	}
};

class CTile
{
private:
	std::array<WallCol, 1000002> wallMemoization;
	int32_t wallWidth;

public:
	CTile()
	{
		wallWidth = 0;
	}

	~CTile()
	{

	}

	void setWallWidth(const int32_t _wallWidth)
	{
		this->wallWidth = _wallWidth;
	}

	void printNumberOfCases()
	{
		long long retVal = 0;

		if (wallWidth != 0)
		{
			retVal = dp(wallWidth, true, true, true, true);
		}
		std::cout << retVal << "\n";
	}

	long long dp(int32_t width, bool row1Isempty, bool row2Isempty, bool row3Isempty, bool row4Isempty)
	{
		long long retVal = 0;
		const int32_t row1Index = row1Isempty ? 1 : 0;
		const int32_t row2Index = row2Isempty ? 1 : 0;
		const int32_t row3Index = row3Isempty ? 1 : 0;
		const int32_t row4Index = row4Isempty ? 1 : 0;
		const bool isfilled = false;
		const bool isEmpty = true;

		if (width <= 1)
		{
			if (width == 1)
			{
				if (((row1Isempty == true) && (row2Isempty == false) && (row3Isempty == false) && (row4Isempty == false)) ||
					((row1Isempty == false) && (row2Isempty == true) && (row3Isempty == false) && (row4Isempty == false)) ||
					((row1Isempty == false) && (row2Isempty == false) && (row3Isempty == true) && (row4Isempty == false)) ||
					((row1Isempty == false) && (row2Isempty == false) && (row3Isempty == false) && (row4Isempty == true))
					)
				{
					retVal = 0;
				}
				else if ((row1Isempty == false) && (row2Isempty == false) && (row3Isempty == false) && (row4Isempty == false))
				{
					retVal = 0;
				}
\				else if ((row1Isempty == true) && (row2Isempty == false) && (row3Isempty == false) && (row4Isempty == true))
				{
					retVal = 0;
				}
				else
				{
					retVal = 1;
				}
			}
			else if (width == 0)
			{
				if ((row1Isempty == true) && (row2Isempty == true) && (row3Isempty == true) && (row4Isempty == true))
				{
					retVal = 1;
				}
				else
				{
					retVal = 0;
				}
			}
			else
			{
				retVal = 0;
			}
		}
		else if (wallMemoization[width].getArr(row1Index, row2Index, row2Index, row3Index) != -1)
		{
			retVal = wallMemoization[width].getArr(row1Index, row2Index, row2Index, row3Index);
		}
		else
		{
			const int32_t openNum = row1Index + row2Index + row3Index + row4Index;
			if (openNum == 4)
			{
				retVal += (dp((width - 1), isEmpty, isEmpty, isEmpty, isEmpty));
				retVal += (dp((width - 1), isEmpty, isEmpty, isfilled, isfilled)) * 2;
				retVal += (dp((width - 1), isfilled, isEmpty, isEmpty, isfilled));
				retVal += (dp((width - 2), isEmpty, isEmpty, isEmpty, isEmpty));
			}
			else if (openNum == 3)
			{
				if ((row1Isempty == false) || (row4Isempty == false))
				{
					retVal += (dp((width - 1), isEmpty, isfilled, isEmpty, isEmpty));
					retVal += (dp((width - 1), isfilled, isEmpty, isEmpty, isEmpty));
					retVal += (dp((width - 1), isfilled, isfilled, isfilled, isEmpty));
				}
				else
				{
					retVal += (dp((width - 1), isfilled, isEmpty, isEmpty, isEmpty));
					retVal += (dp((width - 1), isfilled, isEmpty, isfilled, isfilled));
				}
			}


			else if (openNum == 2)
			{
				if ((row2Isempty == false) && (row3Isempty == false))
				{
					retVal += (dp((width - 1), isfilled, isEmpty, isEmpty, isfilled));
				}

				else if ((row1Isempty == false) && (row4Isempty == false))
				{
					retVal += (dp((width - 1), isEmpty, isEmpty, isEmpty, isEmpty));

					retVal += (dp((width - 1), isEmpty, isfilled, isfilled, isEmpty));
				}

				else
				{
					retVal += (dp((width - 1), isEmpty, isEmpty, isEmpty, isEmpty));
					retVal += (dp((width - 1), isEmpty, isEmpty, isfilled, isfilled));
				}
			}

			else if (openNum == 1)
			{
				retVal += (dp((width - 1), isEmpty, isEmpty, isEmpty, isfilled));
				retVal += (dp((width - 1), isEmpty, isEmpty, isfilled, isEmpty));
			}
			else
			{
				retVal += (dp((width - 1), isEmpty, isEmpty, isEmpty, isEmpty));
			}
			wallMemoization[width].setArr(row1Index, row2Index, row2Index, row3Index, retVal);
		}

		return retVal;
	}

	void printWallMemoization()
	{
		wallMemoization[0].setArr(1, 1, 1, 1, 4);
		wallMemoization[1].setArr(0, 0, 0, 0, 2);

		std::cout << "\n";
		for (int i = 0; i < this->wallWidth; i++)
		{
			for (int index1 = 0; index1 < 2; index1++)
			{
				for (int index2 = 0; index2 < 2; index2++)
				{
					for (int index3 = 0; index3 < 2; index3++)
					{
						for (int index4 = 0; index4 < 2; index4++)
						{
							std::cout << wallMemoization[i].getArr(index1, index2, index3, index4) << " ";
						}
					}
				}
			}

			std::cout << "\n";
		}
	}
};


int main()
{
	std::cin.tie(NULL);
	std::ios::sync_with_stdio(false);

	std::string inputStr;

	int32_t testCase;
	std::cin >> testCase;
	std::cin.ignore();

	CTile* cTile = new CTile();
	for (int i = 0; i < testCase; i++)
	{
		std::getline(std::cin, inputStr);
		std::stringstream ss(inputStr);
		int32_t tempVal;
		ss >> tempVal;
		cTile->setWallWidth(tempVal);
		cTile->printNumberOfCases();
	}
	delete cTile;
