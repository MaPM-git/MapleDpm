package org.mapledpmlab.type.skill.buffskill.luminous;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class EquilibriumMemorize extends BuffSkill {
    public EquilibriumMemorize() {
        this.setName("이퀄리브리엄(메모라이즈)");
        this.setDuration(10L + 7);      // 다크라이트 마스터리
        this.setApplyServerLag(true);
    }
}
