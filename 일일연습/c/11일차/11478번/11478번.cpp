#include <iostream>
#include <string.h>
#include <set>
using namespace std;
#pragma warning(disable: 4996)

#define MAX_LEN 1000 + 1

int main() {
	set<string> string_set;
	char input_str[MAX_LEN];
	scanf("%s", input_str);
	int input_str_len = strlen(input_str);

	for (int part_str_len = 1; part_str_len <= input_str_len; part_str_len++) {
		for (int part_idx = 0; part_idx < input_str_len - part_str_len+1; part_idx++) {
			int start_idx = part_idx;
			int end_idx = part_idx + part_str_len;
			string sub_string(input_str + start_idx, input_str + end_idx);
			string_set.insert(sub_string);
		}
	}
	cout << string_set.size();
	
	return 0;
}