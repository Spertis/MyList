package com.company;

public class Collection {

    class Item {
        private int value;
        private Item next;

        public Item(int value) {
            this.value = value;
            this.next = null;
        }

        public boolean hasNext() {
            if (this.next != null){
                return true;
            }
            else{
                return false;
            }
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Item getNext() {
            return next;
        }

        public void setNext(Item next) {
            this.next = next;
        }
        public String toString() {
            return Long.toString(this.value);
        }
    }

    private Item begin;
    private long counter;

    public Collection() {
        this.begin = null;
        this.counter = 0;
    }

    public long getCounter() {
        return counter;
    }

    public void add(int value) {
        Item item = new Item(value);
        if (this.begin == null) {
            this.begin = item;
        }
        else {
            end().setNext(item);
        }
        this.counter++;
    }

    public Item end() {
        if (this.begin == null) {
            return null;
        }
        Item iter = this.begin;
        while (iter.hasNext()) {
            iter = iter.getNext();
        }
        return iter;
    }
    public String toString() {
        String result = "[";
        if (this.begin == null) {
            return null;
        }
        else {
            Item iter = this.begin;
            while (iter.hasNext()) {
                result += iter.toString() + ", ";
                iter = iter.getNext();
            }
            result += iter.toString();

        }
        result += "]";
        return result;
    }
    public void swap(int firstPos, int secondPos) {
        Item nextLink1 = null;
        Item nextLink2 = null;
        int firstNumber = firstPos;
        int secondNumber = secondPos;
        Item link1 = null;
        Item link2 = null;
        Item previousLink1 = null;
        Item previousLink2 = null;
        boolean flag = (firstPos == 0 || secondPos == 0);


        if (-1 + this.counter >= firstNumber) {
            Item iter = this.begin;
            for (; firstNumber >= 0; --firstNumber) {
                iter = iter.getNext();
            }
            nextLink1 = iter;
            iter = this.begin;
            firstNumber = firstPos;

            for (; firstNumber > 1; --firstNumber) {
                iter = iter.getNext();
            }
            previousLink1 = iter;

            iter = this.begin;
            firstNumber = firstPos;

            for (; firstNumber > 0; --firstNumber) {
                iter = iter.getNext();
            }
            link1 = iter;
        }
        firstNumber = firstPos;


        if (-1 + this.counter >= secondNumber) {
            Item iter = this.begin;
            for (; secondNumber >= 0; --secondNumber) {
                iter = iter.getNext();
            }
            nextLink2 = iter;
            iter = this.begin;
            secondNumber = secondPos;

            for (; secondNumber > 1; --secondNumber) {
                iter = iter.getNext();
            }
            previousLink2 = iter;
            iter = this.begin;
            secondNumber = secondPos;

            for (; secondNumber > 0; --secondNumber) {
                iter = iter.getNext();
            }
            link2 = iter;
            secondNumber = secondPos;

        }
        Item iter = this.begin;

        while (iter != null) {
            if (!flag) {
                if (iter == previousLink1 && previousLink1 != link2) {
                    iter.setNext(link2);
                    iter = iter.getNext();
                    if (Math.abs(secondPos - firstPos) == 1) {
                        iter.setNext(link1);
                        iter = iter.getNext();
                        iter.setNext(nextLink2);
                    } else {
                        iter.setNext(nextLink1);
                    }
                }

                if (iter == previousLink2 && previousLink2 != link1) {
                    iter.setNext(link1);
                    iter = iter.getNext();
                    if (Math.abs(secondPos - firstPos) == 1) {
                        iter.setNext(link2);
                        iter = iter.getNext();
                        iter.setNext(nextLink1);
                    } else {
                        iter.setNext(nextLink2);
                    }
                } else {
                    iter = iter.getNext();
                }

            } else if (firstPos == secondPos) {
                break;
            } else if (flag && firstPos == 0) {
                this.begin = link2;
                iter = this.begin;
                if (previousLink2 != link1) {
                    iter.setNext(nextLink1);

                    while (iter != null) {
                        if (iter == previousLink2) {
                            iter.setNext(link1);
                            iter = iter.getNext();
                            iter.setNext(nextLink2);
                        } else {
                            iter = iter.getNext();

                        }
                    }
                } else {
                    iter.setNext(link1);
                    iter = iter.getNext();
                    iter.setNext(nextLink2);
                    break;
                }
            } else if (flag && secondPos == 0) {
                this.begin = link1;
                iter = this.begin;
                if (previousLink1 != link2) {
                    iter.setNext(nextLink2);

                    while (iter != null) {
                        if (iter == previousLink1) {
                            iter.setNext(link2);
                            iter = iter.getNext();
                            iter.setNext(nextLink1);
                        } else {
                            iter = iter.getNext();
                        }
                    }
                }
                else {
                    iter.setNext(link2);
                    iter = iter.getNext();
                    iter.setNext(nextLink1);
                    break;
                }
            }
        }
    }
    public Item indexAt(int index) {
        if (- 1 + this.counter >= index ) {
            Item iter = this.begin;
            for (;index > 0; --index) {
                iter = iter.getNext();
            }
            return iter;
        }
        return null;
    }
}
