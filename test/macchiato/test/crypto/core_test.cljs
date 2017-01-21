(ns macchiato.test.crypto.core-test
  (:require
    [macchiato.bcrypt :as bcrypt]
    [macchiato.scrypt :as scrypt]
    [cljs.test :refer-macros [async is are deftest testing use-fixtures]]))

(def secret "my secret")

(deftest test-bcrypt
  (is (bcrypt/check secret (bcrypt/encrypt secret)))
  (is (not (bcrypt/check secret (bcrypt/encrypt "some other secret"))))
  (is (not (bcrypt/check "some other secret" (bcrypt/encrypt secret)))))

(deftest test-bcrypt-async
  (async done

    (done)))

(deftest test-scrypt
  (is (scrypt/check secret (scrypt/encrypt secret)))
  (is (not (scrypt/check secret (scrypt/encrypt "some other secret"))))
  (is (not (scrypt/check "some other secret" (scrypt/encrypt secret)))))
