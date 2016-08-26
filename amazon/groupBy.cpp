/*Implement a groupBy function that works on an Array of values.

Example(JavaScript) :
var values = ['cat', 'dog', 'small', 'large'];
groupBy(values, function(value) {
return value.length;
});
-> {5:['small', 'large'], 3 : ['cat', 'dog']}

var values = [1, 2, 6, 25, 30, 56];
groupBy(values, function(value) {
return value * value >= 25;
});
-> {false: [1, 2], true : [6, 25, 30, 56]}

The execution can be anything that works.I am mostly interested in the input and output.
*/

#include "stdafx.h"
#include <map>
#include <vector>
#include <string>
#include <iostream>
#include <cstdlib>
#include <algorithm>
#include <functional>
using namespace std;

int groupByLength(string in) {
	return in.length();
}

bool groupBySqGreaterThan25(int in) {
	return in*in > 25;
}

template<class T, class K>
map<K, vector<T>> groupBy(vector<T> input, std::function<K(T)> lambda) {
	map<K, vector<T>> result;
	for (T &in : input) {
		K key = lambda(in);
		result[key].push_back(in);
	}
	return result;
}

template<class K, class V>
void printMapContents(const map<K, V> &map) {
	for (auto &entry : map) {
		cout << "\"" << entry.first << "\": [ ";
		for (auto element : entry.second) {
			cout << element << ", ";
		}
		cout << "] " << endl;
	}
}

int main() {
	vector<string> lengthArray = { "cat","dog","small","large" };
	auto result = groupBy<string, int>(lengthArray, std::bind(groupByLength, std::placeholders::_1));
	printMapContents(result);

	vector<int> greaterThan25Array = { 2,3,4,6,7,8 };
	auto result2 = groupBy<int, bool>(greaterThan25Array, std::bind(groupBySqGreaterThan25, std::placeholders::_1));
	printMapContents(result2);
	return EXIT_SUCCESS;
}