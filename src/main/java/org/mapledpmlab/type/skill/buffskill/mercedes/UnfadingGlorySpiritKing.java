package org.mapledpmlab.type.skill.buffskill.mercedes;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class UnfadingGlorySpiritKing extends BuffSkill {
    public UnfadingGlorySpiritKing() {
        this.setName("언페이딩 글로리(정령왕)");
        this.setDuration(60L);
    }
}
