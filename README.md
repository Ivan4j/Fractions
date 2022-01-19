# Fractions Calculator

This Fraction Calculator can solve Equations having one, two or many terms.

### Examples:

| #              | Input                         |  Output     |
|----------------|-------------------------------|-------------|
| Single term    | 5_3/4                         | 5_3/4       |
| Two Terms      | 5_3/4 + 4/7                   | 6_9/28      |
| Multiple Terms | 5_3/4 + 4/7 * 3_2/3 - 7 / 3/4 | -1_41/84    |

## Build

In order to compile and generate the .jar file, please run the following command:

(Java 8 or higher is required)

```shell
user@host:~ ./gradlew clean build 
```

## How to use this Program

Arguments have to be passed when executing the program either in the Terminal or by using the `Program arguments` Input box from your IDE

After building the program, arguments can be passed when executing the .jar file as follows:

#### Input: `5_3/4`
```shell
user@host:~ java -jar Fractions-1.0-SNAPSHOT.jar 5_3/4
```
#### Output
```shell
5_3/4
```
#### Input: `5_3/4 + 4/7`
```shell
user@host:~ java -jar Fractions-1.0-SNAPSHOT.jar 5_3/4 + 4/7
```
#### Output
```shell
6_9/28
```
#### Input: `5_3/4 + 4/7 * 3_2/3 - 7 / 3/4`
```shell
user@host:~ java -jar Fractions-1.0-SNAPSHOT.jar 5_3/4 + 4/7 * 3_2/3 - 7 / 3/4
```
#### Output
```shell
-1_41/84
```

## Calculation Order

This program follows the regular order execution.

 * Multiplication or Division first
 * Addition or Subtraction last
 * When more than one operation of the same level exist, those are executed in order: from left to right

## Validation


Arguments should represent a `valid equation` in order to be calculated.

There could exist white spaces between terms or operators, but white spaces are not allowed inside a fraction:
* Valid Input: `3_5/3     +   2/7`
* Valid Input: `2_5/3 * 3 + 2 / 8`
* Invalid Input: `3  _5/3`
* Invalid Input: `2_5 /3 + 2 _ 7/1`

Only Addition `+`, Subtraction`-`, Multiplication `*` and Division`/` operators are allowed