(ns estudo-1.core-test
  (:require [clojure.test :refer :all]
            [estudo-1.core :refer :all]))

(deftest n-test
  (testing "Calculo de taxa até 100"
    (is (= 15 (taxa-entrega 1)))
    (is (= 15 (taxa-entrega 100))))
  (testing "de 100 a 200"
    (is (= 5 (taxa-entrega 100.01)))
    (is (= 5 (taxa-entrega 200))))
  (testing "acima de 200"
    (is (= 0 (taxa-entrega 200.01))))
  )

(deftest n2-test
  (testing "dammy"
    (is (= 1 1))))