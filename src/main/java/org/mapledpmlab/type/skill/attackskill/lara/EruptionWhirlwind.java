package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EruptionWhirlwind extends AttackSkill {
    public EruptionWhirlwind() {
        this.setName("분출 : 돌개바람");
        this.setDelayByAttackSpeed(450L);
        this.setDamage(690.0);
        this.setAttackCount(5L);
        this.setCooldown(13.0);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(1.2);           // 용맥 흡수 VI
        this.addFinalDamage(1.15);      // 잠 깨우기 VI
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.setAddDamage(10L + 15 + 21);   // 분출/흡수 - 리인포스, 보스 킬러
        this.getMultiAttackInfo().add(960L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(2340L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(2340L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(2340L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(2340L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(480L);
    }
}
