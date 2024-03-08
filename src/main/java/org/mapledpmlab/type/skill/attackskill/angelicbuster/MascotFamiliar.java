package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MascotFamiliar extends AttackSkill {
    public MascotFamiliar() {
        this.setName("마스코트 패밀리어");
        this.setDelay(1560L);
        this.setDamage(1540.0);
        this.setAttackCount(5L);
        this.setDotDuration(1560L);
        this.setInterval(120L);
        this.setLimitAttackCount(13L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new MascotFamiliarEnd());
    }
}
