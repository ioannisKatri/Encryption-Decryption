# Encryption-Decryption
A simple app for Encrypting and Decrypting Text


Arguments

 -------> Encryption mode can take two values -> enc, dec.
If it is not specified it will use enc.

 -mode enc



-------> For Input file use -> command -in.
-in one_file.txt



-------> For output file use -> command -out.
-out some_file.txt



-------> Two algorithms are provided -> unicode, shift
If No algorithm is specified it will use shift.

-alg unicode




-------> key command it will shift each letter by the specified number according to its order in the alphabet.
(max 23)
 -key 5



-------> Lastly it can be used without -in and -out, just by adding text using -->  -data.

-data "Welcome to!"



Examples of use:


-> java Main -mode enc -in road_to_treasure.txt -out protected.txt -key 5 -alg unicode

-> java Main -key 5 -alg unicode -data "\jqhtrj%yt%m~ujwxpnqq&" -mode dec

-> java Main -key 5 -alg shift -data "Welcome to hyperskill!" -mode enc

-> java Main -key 5 -alg shift -data "Bjqhtrj yt mdujwxpnqq!" -mode dec
