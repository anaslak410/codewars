def longest(s1, s2) :

    s3 = s1 + s2
    return "".join(sorted(set(s3)))