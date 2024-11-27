package org.mapledpmlab.type.skill.buffskill.luminous;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Equilibrium extends BuffSkill {
    public Equilibrium() {
        this.setName("이퀄리브리엄");
        this.setDuration(10L + 7);      // 다크라이트 마스터리
        this.setApplyPlusBuffDuration(true);
        this.setApplyServerLag(true);
        this.setDelay(30L);
    }
}
