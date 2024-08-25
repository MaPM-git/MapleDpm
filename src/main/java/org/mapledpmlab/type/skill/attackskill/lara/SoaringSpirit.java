package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SoaringSpirit extends AttackSkill {
    public SoaringSpirit() {
        this.setName("용솟음치는 정기");
        this.setDamage(1500.0);
        this.setAttackCount(8L);
        this.setDelay(630L);
        this.setCooldown(20.0);
        this.addFinalDamage(1.6);   // 코어강화
        this.addFinalDamage(1.08);      // 오버로드 마나
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(900L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(120L);
    }
}
