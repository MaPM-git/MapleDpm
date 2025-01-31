package org.mapledpmlab.type.skill.attackskill.soulmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SolunarPower2 extends AttackSkill {
    public SolunarPower2() {
        this.setName("솔루나 파워 II");
        this.setAttackCount(5L * 2);
        this.setDamage(860.0);
        this.addFinalDamage(0.9);       // 마스터 오브 더 소드
        this.getMultiAttackInfo().add(2010L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
