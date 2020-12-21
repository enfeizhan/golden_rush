package main

import (
    "fmt"
    "strconv"
)

func main() {
    var i int = 42;
    fmt.Println(i);
    j := 24;
    fmt.Println(j);
    fmt.Printf("%v, %T\n", j, j);
    var k string;
    k = strconv.Itoa(j);
    fmt.Printf("%v, %T\n", k, k);
    fmt.Println("Hello Go!");
}
