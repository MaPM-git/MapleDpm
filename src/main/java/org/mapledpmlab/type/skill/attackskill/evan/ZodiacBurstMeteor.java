package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ZodiacBurstMeteor extends AttackSkill {
    public ZodiacBurstMeteor() {
        this.setName("조디악 버스트(유성우)");
        this.setDamage(1080.0);
        this.setAttackCount(8L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setCooldown(3.0);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
    }
}
