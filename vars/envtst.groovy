class envtst implements Serializable {
  static methodA() {
    def en = System.getenv().JAVA_HOME
    return en
  }
}
