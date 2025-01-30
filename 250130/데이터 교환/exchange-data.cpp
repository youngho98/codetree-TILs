#include <iostream>
using namespace std;

int main() {
    // Please write your code here.
    int a = 5;
    int b = 6;
    int c = 7;
    int b_temp = b;
    int c_temp = c;
    b = a;
    c = b_temp;
    a = c_temp;
    cout << a << "\n" << b << "\n" << c;
    return 0;
}