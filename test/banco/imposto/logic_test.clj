(ns banco.imposto.logic-test
  (:require [banco.imposto.imposto :as logic]
    ;[banco.imposto.logic :refer [imposto-retido-font]]
            [clojure.test :refer :all]))

(deftest imposto-retido-font-test
  (testing "Dado valor imposto retido #1"
    (is (= 0 (logic/imposto-retido-font 1))))
  (testing "Valor igual ou superior de 1000.00 10%"
    (is (= 100.0 (logic/imposto-retido-font 1000)))))

(deftest test
  (testing "test"
    (is (= true (logic/esta-na-faixa-isencao? 900)))))