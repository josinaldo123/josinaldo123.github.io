import numpy as np

#Declarando as matrizes

ma = np.array([[1,1],[2,1]])
mb = np.array([[4],[1]])

#Encontrar a inversa da matriz ma

ma_inversa = np.linalg.inv(ma)

#Encontrar o valor de x pela matriz

x = np.dot(ma_inversa, mb)

x = np.linalg.solve(ma,mb)

print(x)
