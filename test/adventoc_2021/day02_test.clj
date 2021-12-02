(ns adventoc-2021.day02-test
  (:require [clojure.test :refer [deftest is]]
            [adventoc-2021.day02 :refer [navigate initial_location determine_location location_multiplied]]
            [clojure.java.io :as io]))

(deftest navigate_test1
  (let [expected {:horizonal 1 :depth 0}
        nav (navigate initial_location "forward 1")]
    (is (= (expected :horizonal) (nav :horizontal)))
    (is (= (expected :depth) (nav :depth)))))

(deftest navigate_test2
  (let [expected {:horizonal 0 :depth 1}
        nav (navigate initial_location "down 1")]
    (is (= (expected :horizonal) (nav :horizontal)))
    (is (= (expected :depth) (nav :depth)))))

(deftest navigate_test3
  (let [expected {:horizonal 0 :depth -1}
        nav (navigate initial_location "up 1")]
    (is (= (expected :horizonal) (nav :horizontal)))
    (is (= (expected :depth) (nav :depth)))))

(deftest determine_location_test1
  (let [expected {:horizonal 0 :depth -1}
        location (determine_location "up 1")]
    (is (= (expected :horizonal) (location :horizontal)))
    (is (= (expected :depth) (location :depth)))))

(deftest determine_location_test2
  (let [expected {:horizonal 1 :depth -1}
        location (determine_location "up 1\nforward 1")]
    (is (= (expected :horizonal) (location :horizontal)))
    (is (= (expected :depth) (location :depth)))))

(deftest determine_location_test3
  (let [expected {:horizonal 1 :depth 2}
        location (determine_location "up 1\nforward 1\ndown 3")]
    (is (= (expected :horizonal) (location :horizontal)))
    (is (= (expected :depth) (location :depth)))))

(deftest determine_location_test_main
  (let [expected {:horizonal 1980 :depth 866}
        location (determine_location (slurp (io/resource "day02.txt")))]
    (is (= (expected :horizonal) (location :horizontal)))
    (is (= (expected :depth) (location :depth)))))

(deftest multiply_location_test
  (is (= 1,714,680 (location_multiplied (determine_location (slurp (io/resource "day02.txt")))))))
