# API Documentation

## Endpoint

```bash
GET /generate-list
```

## Description
Generate a list of strings based on provided parameters.

## Parameters
- `int1` (integer): The first integer.
- `int2` (integer): The second integer.
- `limit` (integer): The limit for the list of numbers.
- `str1` (string): The replacement string for multiples of int1.
- `str2` (string): The replacement string for multiples of int2.

## Example
### Request
GET /generate-list?int1=3&int2=5&limit=20&str1=Fizz&str2=Buzz


### Response
```json
[
  "1",
  "2",
  "Fizz",
  "4",
  "Buzz",
  "Fizz",
  "7",
  "8",
  "Fizz",
  "Buzz",
  "11",
  "Fizz",
  "13",
  "14",
  "FizzBuzz",
  "16",
  "17",
  "Fizz",
  "19",
  "Buzz"
]
```

## Notes
- The list contains numbers from 1 to the specified limit.
- Multiples of int1 are replaced with str1.
- Multiples of int2 are replaced with str2.
- Multiples of both int1 and int2 are replaced with str1str2.

