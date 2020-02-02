import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class DayTwoPartOneTest {

    private static Stream<Data> data() {

        return Stream.of(
                new Data(new int[] {1, 0, 0, 0}, new int[] {2, 0, 0, 0}),
                new Data(new int[] {2, 1, 1, 3}, new int[] {2, 1, 1, 1}),
                new Data(new int[] {99, 0, 0, 0}, new int[] {99, 0, 0, 0}),
                new Data(new int[] {1, 1, 1, 4, 99, 5, 6, 0, 99}, new int[] {30, 1, 1, 4, 2, 5, 6, 0, 99}),
                new Data(new int[] {1, 0, 0, 0, 99}, new int[] {2,0,0,0,99}),
                new Data(new int[] {2,3,0,3,99}, new int[] {2,3,0,6,99}),
                new Data(new int[] {2,4,4,5,99,0}, new int[]{2,4,4,5,99,9801})
        );
    }

    @MethodSource("data")
    @ParameterizedTest
    void correctOpCodeIsReturned(final Data data) {

        assertThat(DayTwo.opcodeCalculation(data.opcode)).isEqualTo(data.newopcode);
    }

    private static class Data {

        private int[] opcode;
        private int[] newopcode;

        public Data(final int[] opcode, final int[] newopcode) {

            this.opcode = opcode;
            this.newopcode = newopcode;
        }
    }
}