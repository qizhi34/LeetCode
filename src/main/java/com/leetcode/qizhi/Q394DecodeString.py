#! /usr/bin/env python
# -*- coding: utf-8 -*-
import re

class Solution(object):
    def decodeString(self, s):
        while '[' in s:
            s=re.sub(r'(\d+)\[([a-z]*)\]', lambda m: int(m.group(1)) * m.group(2), s)
        return s


if __name__=="__main__":
    solution = Solution()
    print solution.decodeString("3[a]2[bc]")



