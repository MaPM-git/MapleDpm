package org.mapledpmlab.type.skill.buffskill.luminous;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Memorize extends BuffSkill {
    public Memorize() {
        this.setName("메모라이즈");
        this.setCooldown(150.0);
        this.setDelay(900L);
        this.setRelatedSkill(new EquilibriumMemorize());
    }
}
