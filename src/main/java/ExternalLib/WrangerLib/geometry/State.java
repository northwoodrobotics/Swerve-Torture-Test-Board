package ExternalLib.WrangerLib.geometry;

import ExternalLib.WrangerLib.util.CSVWritable;
import ExternalLib.WrangerLib.util.Interpolable;

public interface State<S> extends Interpolable<S>, CSVWritable {
    double distance(final S other);

    boolean equals(final Object other);

    String toString();

    String toCSV();
}
