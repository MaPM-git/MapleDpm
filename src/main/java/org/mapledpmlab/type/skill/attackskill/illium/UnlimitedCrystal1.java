package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnlimitedCrystal1 extends AttackSkill {
    public UnlimitedCrystal1() {
        this.setName("언리미티드 크리스탈1");
        this.setAttackCount(8L);
        this.setCooldown(360.0);
        this.setDamage(1200.0);
        this.setDelay(780L);
        this.setRelatedSkill(new UnlimitedCrystal2());
        this.addFinalDamage(1.08);  // 오버로드 마나
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.setApplyFinalAttack(true);
    }
}
