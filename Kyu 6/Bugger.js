function persistence(num) {
    var result = 0;
    while (num >= 10) {
        var digits = num.toString().split("");
        var first = digits[0];
        for (var i = 1; i < digits.length; i++) {
            first *= parseInt(digits[i]);
        }
        num = first;
        result++;
    }
    return result;
}