package cn.edu.pku.sei.plde.ACS.localization.common.junit;

import cn.edu.pku.sei.plde.ACS.localization.common.container.classic.MetaSet;

import java.util.Collection;

public class TestCase {

    public static TestCase from(String qualifiedClassName, String testName, int testNumber) {
        return new TestCase(qualifiedClassName, testName, testNumber);
    }

    public static Collection<String> testClasses(Collection<TestCase> testCases) {
        Collection<String> testClasses = MetaSet.newHashSet();
        for (TestCase testCase : testCases) {
            testClasses.add(testCase.className());
        }
        return testClasses;
    }

    public static Collection<String> testNames(Collection<TestCase> testCases) {
        Collection<String> testNames = MetaSet.newHashSet();
        for (TestCase testCase : testCases) {
            testNames.add(testCase.testName());
        }
        return testNames;
    }

    private TestCase(String qualifiedClassName, String testName, int testNumber) {
        this.qualifiedClassName = qualifiedClassName;
        this.testNumber = testNumber;
        this.testName = testName;
    }

    public String className() {
        return qualifiedClassName;
    }

    public String testName() {
        return testName;
    }

    public int testNumber() {
        return testNumber;
    }

    @Override
    public String toString() {
        return className() + "#" + testName();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((className() == null) ? 0 : className().hashCode());
        result = prime * result + ((testName() == null) ? 0 : testName().hashCode());
        result = prime * result + testNumber();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TestCase other = (TestCase) obj;
        if (className() == null) {
            if (other.className() != null)
                return false;
        } else if (!className().equals(other.className()))
            return false;
        if (testName() == null) {
            if (other.testName() != null)
                return false;
        } else if (!testName().equals(other.testName()))
            return false;
        if (testNumber() != other.testNumber())
            return false;
        return true;
    }

    private int testNumber;
    private String testName;
    private String qualifiedClassName;
}
