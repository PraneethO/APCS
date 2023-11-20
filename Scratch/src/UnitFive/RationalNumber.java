
class RationalNumber {
    private int p;
    private int q;

    public RationalNumber(int p, int q) {
        this.p = p;
        this.q = q;
    }

    public int getP() {
        return p;
    }

    public int getQ() {
        return q;
    }

    public RationalNumber add(RationalNumber r) {
        int num = (this.p * r.q) + (r.p * this.q);
        int denom = (this.q * r.q);

        int gcf = getGCF(num, denom);

        return new RationalNumber(num / gcf, denom / gcf);
    }

    public RationalNumber subtract(RationalNumber r) {
        int num = (this.p * r.q) - (r.p * this.q);
        int denom = (this.q * r.q);

        int gcf = getGCF(num, denom);

        return new RationalNumber(num / gcf, denom / gcf);
    }

    public RationalNumber multiply(RationalNumber r) {
        return new RationalNumber(this.p * r.p, this.q * r.q);
    }

    public RationalNumber divide(RationalNumber r) {
        int GCF = getGCF(this.p * r.q, this.q * r.p);

        return new RationalNumber((this.p * r.q) / GCF, (this.q * r.p) / GCF);
    }

    public double toDecimal() {
        return (double) this.p / this.q;
    }

    public RationalNumber getReciprocal() {
        return new RationalNumber(this.q, this.p);
    }

    public boolean equals(Object o) {
        return true;
    }

    public String toString() {
        return this.p + " / " + this.q;
    }

    public int compareTo(RationalNumber r) {
        return 0;
    }

    public void reduce() {
        int GCF = getGCF(this.p, this.q);

        this.p /= GCF;
        this.q /= GCF;
    }

    public RationalNumber abs() {
        return new RationalNumber(Math.abs(p), q);
    }

    public static int getGCF(int num1, int num2) {
        if (num1 == 0) {
            return 0;
        }
        if (num2 == 0) {
            return 0;
        }

        if (num1 < 0)
            num1 *= -1;
        if (num2 < 0)
            num2 *= -1;

        while (num1 != num2) {
            if (num1 > num2)
                num1 -= num2;
            else
                num2 -= num1;
        }

        return num1;
    }

}