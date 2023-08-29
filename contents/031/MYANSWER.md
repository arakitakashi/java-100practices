# 回答

## 妥当ではない。
理想としては、getStringClass()の戻り値型にジェネリクスを指定して型安全にすべきだが、今回はそれは対象外。
であれば、スコープを最小限にすることが求められるため、

```
@SuppressWarnings("unchecked")
Class<String> object = getStringClass();
// Class<String>にClassを渡そうとしている。
```

とすべき。