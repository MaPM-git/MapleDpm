package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LightReflection extends AttackSkill {
    public LightReflection() {
        this.setName("라이트 리플렉션");
        this.setDamage(810.0);
        this.setDelayByAttackSpeed(810L);
        this.setAttackCount(4L * 2);
        this.addFinalDamage(0.75);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);     // 라이트 리플렉션-리인포스
    }
}
