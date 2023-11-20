public class MixedNumber implements Comparable<MixedNumber> {
    // Composition: HAS-A - when one class has as its instance data an instance of
    // another class

    private int whole;
    private RationalNumber frac;

    public MixedNumber(RationalNumber r) {
        whole = r.getP() / r.getQ();
        frac = new RationalNumber(r.getP() % r.getQ(), r.getQ());
    }

    public MixedNumber add(MixedNumber m) {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        RationalNumber sum = thisRat.add(mRat);

        return new MixedNumber(sum);
    }

    public MixedNumber subtract(MixedNumber m) {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        RationalNumber diff = thisRat.subtract(mRat);

        return new MixedNumber(diff);
    }

    public MixedNumber multiply(MixedNumber m) {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        RationalNumber mult = thisRat.multiply(mRat);

        return new MixedNumber(mult);
    }

    public MixedNumber divide(MixedNumber m) {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();
        RationalNumber div = thisRat.divide(mRat);

        return new MixedNumber(div);
    }

    public double toDecimal() {
        return whole + (double) frac.getP() / frac.getQ();
    }

    public RationalNumber toRational() {
        int num = whole * frac.getQ() + frac.getP();

        return new RationalNumber(num, frac.getQ());
    }

    public String toString() {
        if (whole == 0)
            return frac + "";
        if (frac.getP() == 0)
            return whole + "";
        return whole + " " + frac.abs().toString();
    }

    public boolean equals(Object o) {
        MixedNumber m = (MixedNumber) o;

        return this.whole == m.whole && this.frac.equals(m.frac);
    }

    public int compareTo(MixedNumber m) {
        RationalNumber thisRat = this.toRational();
        RationalNumber mRat = m.toRational();

        return thisRat.compareTo(mRat);
    }
}
