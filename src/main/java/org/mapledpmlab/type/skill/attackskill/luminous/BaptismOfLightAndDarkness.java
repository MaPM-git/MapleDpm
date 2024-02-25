package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BaptismOfLightAndDarkness extends AttackSkill {
    public BaptismOfLightAndDarkness() {
        this.setName("빛과 어둠의 세례");
        this.setDamage(990.0);
        this.setDelay(940L);
        this.setAttackCount(7L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setCooldown(45.0);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(300L);
        this.getMultiAttackInfo().add(300L);
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(150L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(360L);
    }
}
