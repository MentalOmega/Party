var XX = {};

// 学号验证
XX.isStudentID = function(str) {
    if(typeof str === 'number') {
        str = str.toString();
    }
    return /^3\d{9}/.test(str);
};
