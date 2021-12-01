(ns adventoc-2021.day01-test
  (:require [clojure.test :refer [deftest is]]
            [adventoc-2021.day01 :refer [count_increments, sonar_sweep, sonar_sweep_sliding]]
            [clojure.java.io :as io]))



(deftest count_increments_test1
  (let [expected 0]
    (is (= expected (count_increments [])))))

(deftest count_increments_test2
  (let [expected 0]
    (is (= expected (count_increments [1])))))


(deftest count_increments_test3
  (let [expected 1]
    (is (= expected (count_increments [1 2])))))


(deftest count_increments_test4
  (let [expected 4]
    (is (= expected (count_increments [1 2 3 4 5])))))

(deftest count_increments_test5
  (let [expected 4]
    (is (= expected (count_increments [1 2 2 3 1 4 4 5])))))

(deftest count_increments_test6
  (let [expected 50]
    (is (= expected (count_increments [104
                                       105
                                       109
                                       120
                                       124
                                       113
                                       120
                                       121
                                       122
                                       123
                                       134
                                       133
                                       134
                                       150
                                       160
                                       165
                                       179
                                       178
                                       180
                                       178
                                       196
                                       197
                                       198
                                       204
                                       197
                                       213
                                       206
                                       207
                                       209
                                       210
                                       211
                                       223
                                       212
                                       224
                                       228
                                       238
                                       237
                                       238
                                       242
                                       245
                                       249
                                       250
                                       253
                                       248
                                       261
                                       265
                                       274
                                       276
                                       274
                                       275
                                       278
                                       275
                                       276
                                       267
                                       266
                                       272
                                       275
                                       279
                                       280
                                       286
                                       282
                                       292
                                       308
                                       323
                                       324
                                       319
                                       310
                                       304])))))


(deftest sonar_sweep_test
  (let [expected 1557]
    (is (= expected (sonar_sweep (slurp (io/resource "day01.txt")))))))


(deftest sonar_sweep_sliding_test
  (let [expected 1608]
    (is (= expected (sonar_sweep_sliding (slurp (io/resource "day01.txt")))))))
