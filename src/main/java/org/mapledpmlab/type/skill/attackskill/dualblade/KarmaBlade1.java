package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class KarmaBlade1 extends AttackSkill {
    public KarmaBlade1() {
        this.setName("카르마 블레이드1");
        this.setAttackCount(10L);
        this.setCooldown(360.0);
        this.setDamage(960.0);
        this.setDelay(180L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setRelatedSkill(new KarmaBlade2());
        this.addFinalDamage(0.85);           // 미러 이미징
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
