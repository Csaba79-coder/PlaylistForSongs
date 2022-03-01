package model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Song {

    private String title;
    private double duration;

    @Override
    public String toString() {
        // return super.toString();
        return this.title + ": " + this.duration;
    }
}
