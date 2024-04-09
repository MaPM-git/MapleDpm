package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TranscendentLight extends BuffSkill {
    public TranscendentLight() {
        this.setName("트랜센던트(빛)");
        this.setDuration(20L);
        this.setRelatedSkill(new TranscendentTime());
    }
}
