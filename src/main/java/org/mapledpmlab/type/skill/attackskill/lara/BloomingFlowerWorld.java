package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BloomingFlowerWorld extends AttackSkill {
    public BloomingFlowerWorld() {
        this.setName("새록새록 꽃누리(꽃)");
        this.setAttackCount(7L);
        this.setCooldown(360.0);
        this.setDamage(2100.0);
        this.setDelay(2160L);
        this.setRelatedSkill(new BloomingFlowerWorldFinish());
        this.setAddDamage(50L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(1740L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
