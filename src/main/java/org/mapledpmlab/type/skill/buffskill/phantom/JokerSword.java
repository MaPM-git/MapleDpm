package org.mapledpmlab.type.skill.buffskill.phantom;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class JokerSword extends BuffSkill {
    public JokerSword() {
        this.setName("조커(날카로운 검)");
        this.setDuration(30L);
        this.addBuffFinalDamage(1.06);
        this.setApplyServerLag(true);
    }
}
