package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class KarmaBlade1 extends AttackSkill {
    public KarmaBlade1() {
        this.setName("카르마 블레이드1");
        this.setAttackCount(5L);
        this.setCooldown(360.0);
        this.setDamage(960.0);
        this.setDelay(180L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new KarmaBlade2());
        this.addFinalDamage(1.7);           // 미러 이미징
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
