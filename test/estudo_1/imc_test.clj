(ns estudo-1.imc-test
  (:require [clojure.test :refer :all])
  (:require [estudo-1.imc :refer [imc-indicator]]))

:low
:high
:ideal

(deftest givenValidParams-WhenCallsImc-ThenValidInstance
  (testing "weight person imc low"
    (is (= :low (imc-indicator 1 2))))
  (testing "weight idea"
    (is (= :idea (imc-indicator 70 1.70))))
  (testing "high imc"
    (is (= :high (imc-indicator 100 1.50)))))


