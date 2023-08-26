## FileCopy App

### v1

- Os nomes dos arquivos (origem e destino) devem ser definidos via argumentos de linha de comando (Dica: usar o String args[] do método main).
- A leitura e gravação devem ser realizadas byte a byte.
- Ao final, deve-se exibir o tempo total da cópia em milisegundos, caso a cópia tenha sido bem sucedida. Dica: pode-se usar o método System.currentTimeMillis().
- Em caso de qualquer erro, enviar uma mensagem pela saída padrão de erro (System.err).

### v2

- A leitura e gravação devem ser realizadas em blocos de bytes (buffer) e não byte a byte.

Dica: usar os métodos read(byte[] b) e write(byte[] b) de FileInputStream e FileOutputStream, respectivamente. Testar a cópia com arquivos grandes. Usar blocos de 8192 bytes. Exemplo:

```java
byte[] buffer = new byte[8192];
fis.read(buffer);
```

- Comparar o tempo de cópia de arquivos grandes usando a Questão 1 e a Questão 2.

```sh
- tempo de leitura do arquivo 'metadata.txt'
tempo v1: 9831ms
tempo v2: 6ms
```

### v3

- um converso que deve ler um arquivo texto com codificação ISO-8859-1 e convertê-lo para UTF-8.

exemplo:

```bash
java ./FileCopyAppV3.java metadata-iso-8859-1.sty meta-iso.txt
```

## TextWriterApp

- obter via teclado uma sequência de linhas de texto até que uma linha contendo somente a String "FIM" seja digitada. Depois disso, solicitar o nome do arquivo via teclado e salvar todas as linhas de texto digitadas no arquivo solicitado. A linha contendo a String "FIM" não deve ser salva no arquivo.
