boolean sameColor(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return allEqual(a.getCol() / 3, b.getCol() / 3, c.getCol() / 3);
}

boolean sameShape(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return allEqual(a.getCol() % 3, b.getCol() % 3, c.getCol() % 3);
}

boolean sameFill(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return allEqual(a.getRow() / 3, b.getRow() / 3, c.getRow() / 3);
}

boolean sameCount(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return allEqual(a.getRow() % 3, b.getRow() % 3, c.getRow() % 3);
}

boolean diffColor(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return allDifferent(a.getCol() / 3, b.getCol() / 3, c.getCol() / 3);
}

boolean diffShape(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return allDifferent(a.getCol() % 3, b.getCol() % 3, c.getCol() % 3);
}

boolean diffFill(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return allDifferent(a.getRow() / 3, b.getRow() / 3, c.getRow() / 3);
}

boolean diffCount(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return allDifferent(a.getRow() % 3, b.getRow() % 3, c.getRow() % 3);
}  

boolean isSet(Card a, Card b, Card c) {
  // YOU WRITE THIS
  return (sameColor(a, b, c) || diffColor(a, b, c)) && (sameShape(a, b, c) || diffShape(a, b, c)) 
          && (sameFill(a, b, c) || diffFill(a, b, c)) && (sameCount(a, b, c) || diffCount(a, b, c));
}

boolean allEqual(int a, int b, int c) {
  return a == b && b == c && a == c;
}

boolean allDifferent(int a, int b, int c) {
  return a != b && b != c && a != c;
}
