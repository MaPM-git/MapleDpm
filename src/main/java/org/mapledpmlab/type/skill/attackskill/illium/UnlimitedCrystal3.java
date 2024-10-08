package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.illium.UnlimitedCrystalBuff;

public class UnlimitedCrystal3 extends AttackSkill {
    public UnlimitedCrystal3() {
        this.setName("언리미티드 크리스탈3");
        this.setAttackCount(15L);
        this.setDamage(1500.0);
        this.setDelay(1800L);
        this.setRelatedSkill(new UnlimitedCrystalBuff());
        this.addFinalDamage(1.08);  // 오버로드 마나
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.getMultiAttackInfo().add(1320L);
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
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.setApplyFinalAttack(true);
    }
}
