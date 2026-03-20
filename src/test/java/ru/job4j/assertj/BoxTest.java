package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

class BoxTest {

    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEmpty()
                .doesNotContain("Cube");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Cube")
                .doesNotContain("SAP")
                .isNotEmpty();
    }

    @Test
    void getNumberOfVerticesSphere() {
        Box box = new Box(0, 10);
        assertThat(box.getNumberOfVertices()).isEqualTo(0)
                .isNotNegative();
    }

    @Test
    void getNumberOfVerticesCube() {
        Box box = new Box(8, 20);
        assertThat(box.getNumberOfVertices()).isEqualTo(8)
                .isEven()
                .isGreaterThanOrEqualTo(8);
    }

    @Test
    void isExistsTetrahedron() {
        Box box = new Box(4, 7);
        assertThat(box.isExist()).isTrue()
                .isNotNull()
                .isNotEqualTo(false);
    }

    @Test
    void isNotExistsTetrahedron() {
        Box box = new Box(3, 7);
        assertThat(box.isExist()).isFalse()
                .isNotEqualTo(true);

    }

    @Test
    void getAreaCube() {
        Box box = new Box(8, 3);
        assertThat(box.getArea()).isEqualTo(54)
                .isGreaterThan(53.25d)
                .isLessThan(54.26d);
    }

    @Test
    void getAreaSphere() {
        Box box = new Box(0, 8);
        assertThat(box.getArea()).isEqualTo(804.24, withPrecision(0.008d))
                .isCloseTo(804.23d, withPrecision(0.02d))
                .isCloseTo(804.2d, Percentage.withPercentage(1.0d))
                .isGreaterThan(803d)
                .isLessThan(806d);
    }
}