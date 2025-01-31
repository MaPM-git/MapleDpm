package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EternalLightness extends AttackSkill {
    public EternalLightness() {
        this.setName("이터널 라이트니스");
        this.setDamage(1355.0);
        this.setAttackCount(7L * 2);
        this.addFinalDamage(0.75);
        this.getMultiAttackInfo().add(300L);
        this.setCooldown(2.0);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
