# Cryptography Ciphers in Java
This repository contains Java implementations of various classical cryptographic ciphers. These ciphers are fundamental in understanding how encryption techniques evolved over time. The following encryption algorithms are included:

# Implemented Ciphers
Caesar Cipher - A simple substitution cipher that shifts characters by a fixed number of positions in the alphabet.

Encryption Algorithm

	1.	Input: Take a plaintext message and an integer shift value .
	2.	Initialize: Set a variable `ciphertext` to an empty string.
	3.	Iterate: For each character  in the plaintext:
	•	If  is a letter (uppercase or lowercase):
	•	Convert the letter to its corresponding index (A=0, B=1, …, Z=25).
	•	Calculate the new index using:  \text{new_index} = (\text{original_index} + k) \mod 26 
	•	Convert the new index back to a letter and append it to `ciphertext`.
	•	If  is not a letter, append it unchanged.
	4.	Output: Return the `ciphertext`.
Decryption Algorithm

	1.	Input: Take the ciphertext and the integer shift value .
	2.	Initialize: Set a variable `plaintext` to an empty string.
	3.	Iterate: For each character  in the ciphertext:
	•	If  is a letter:
	•	Convert it to its corresponding index.
	•	Calculate the new index using:  \text{new_index} = (\text{original_index} - k + 26) \mod 26 
	•	Convert back to a letter and append it to `plaintext`.
	•	If  is not a letter, append it unchanged.
	4.	Output: Return the `plaintext`.
 
Monoalphabetic Cipher - A substitution cipher where each letter in the plaintext is replaced with a corresponding letter from a fixed shuffled alphabet.

Encryption Algorithm

	1.	Input: Define a substitution alphabet that maps each letter of the plaintext to a different letter in the ciphertext.
	2.	Initialize: Set a variable `ciphertext` to an empty string.
	3.	Iterate: For each character  in the plaintext:
	•	If  is in the defined alphabet:
	•	Replace it with its corresponding character from the substitution alphabet and append to `ciphertext`.
	•	If  is not in the defined alphabet, append it unchanged.
	4.	Output: Return the `ciphertext`.
Decryption Algorithm

	1.	Input: Take the ciphertext and the substitution alphabet used for encryption.
	2.	Initialize: Set a variable `plaintext` to an empty string.
	3.	Iterate: For each character  in the ciphertext:
	•	If  is in the substitution alphabet:
	•	Replace it with its corresponding character from the original alphabet and append to `plaintext`.
	•	If  is not in the substitution alphabet, append it unchanged.
	4.	Output: Return the `plaintext`.
Playfair Cipher - A digraph substitution cipher that encrypts pairs of letters using a 5x5 matrix.

Encryption Algorithm:

	1.	Key Square Generation: A 5x5 grid (key square) is created using a keyword. The keyword’s unique letters are placed first, followed by the remaining letters of the alphabet. ‘I’ and ‘J’ are treated as the same letter to fit the alphabet into the 25-letter grid.
	2.	Plaintext Preparation:
	•	The plaintext is divided into digraphs (pairs of letters).
	•	If there’s an odd number of letters, an ‘X’ is added to the end.
	•	If a pair has identical letters, the second occurrence is replaced with ‘X’ (e.g., “butter” becomes “butxer”). Sometimes a bogus letter like ‘X’ is added to repeated letters, so “Hello” becomes “he lx lo”.
	3.	Encryption Rules:
	•	Same Row: If both letters are in the same row, take the letter to the right of each (wrapping around to the beginning of the row if necessary).
	•	Same Column: If both letters are in the same column, take the letter below each (wrapping around to the top of the column if necessary).
	•	Rectangle: If the letters are in different rows and columns, form a rectangle with the two letters and take the letters on the horizontal opposite corners of the rectangle.
Decryption Algorithm: The decryption process is the reverse of encryption, using the same key square

Hill Cipher - A polygraphic substitution cipher based on matrix multiplication.

Encryption Algorithm:

	1.	Key Matrix Creation: Choose a keyword and form a square key matrix (e.g., 2x2 or 3x3) from the letters of the keyword. Ensure the matrix is invertible (determinant is non-zero modulo 26).
	2.	Plaintext Preparation:
	•	Convert the plaintext into numerical values (A=0, B=1, …, Z=25).
	•	Split the plaintext into blocks corresponding to the size of the key matrix (e.g., pairs for a 2x2 matrix).
	3.	Matrix Multiplication:
	•	For each block, represent it as a column vector.
	•	Multiply the key matrix by the plaintext vector:  C = K \cdot P \mod 26 
	•	Convert the resulting numerical values back to letters to form the ciphertext.
Decryption Algorithm:

	3.	Inverse Key Matrix Calculation:
	•	Calculate the determinant of the key matrix.
	•	Find the multiplicative inverse of the determinant modulo 26.
	•	Compute the adjugate matrix.
	2.	Plaintext Recovery:
	•	For each block of ciphertext, convert it into a column vector.
	•	Multiply by the inverse key matrix:  P = K^{-1} \cdot C \mod 26 
	•	Convert numerical values back to letters to recover the plaintext.
 
Vigenère Cipher - A polyalphabetic substitution cipher that encrypts text using a repeating keyword-based shifting technique.

Encryption Algorithm:

	5.	Key Preparation: Choose a keyword and repeat it to match the length of the plaintext.
	2.	Plaintext and Key Conversion:
	•	Convert both plaintext and repeated keyword into numerical values (A=0, B=1, …, Z=25).
	3.	Character-wise Addition:
	•	For each character in the plaintext, add its corresponding character in the key modulo 26:  C_i = (P_i + K_i) \mod 26 
	•	Convert back to letters to form the ciphertext.
Decryption Algorithm:

	7.	Key Preparation: Repeat the keyword to match the length of the ciphertext.
	2.	Ciphertext and Key Conversion:
	•	Convert both ciphertext and repeated keyword into numerical values.
	3.	Character-wise Subtraction:
	•	For each character in the ciphertext, subtract its corresponding character in the key modulo 26:  P_i = (C_i - K_i + 26) \mod 26 
	•	Convert back to letters to recover the plaintext.

Feistel Cipher - A symmetric encryption algorithm that splits plaintext into two halves and processes them through multiple rounds using a round function, key, and XOR operations. It forms the basis of many modern block ciphers like DES

Data Encryption Standard (DES)

Input: Plaintext, Key

Output: Ciphertext

1. Apply Initial Permutation to the Plaintext.
2. Divide the Plaintext into Left and Right halves.
3. For 16 rounds:
   a. Expand the Right half using Expansion Permutation.
   b. XOR with the Key for the current round.
   c. Substitute using S-boxes.
   d. Permute the result using the P-box.
   e. XOR the result with the Left half.
   f. Swap Left and Right halves.
4. Combine the halves and apply the Final Permutation.
5. Return Ciphertext.


