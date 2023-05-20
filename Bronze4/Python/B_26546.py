def reverse(string, start_idx, end_idx):
    return "".join([word[1] for word in enumerate(string) if int (start_idx) > word[0] or word[0] >= int(end_idx)])

if __name__ == "__main__":
    for _ in range(int(input())):
        string, start_idx, end_idx = input().split()

        print(reverse(string=string, start_idx=start_idx, end_idx=end_idx))