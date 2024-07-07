package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IceAura extends AttackSkill {
    public IceAura() {
        this.setName("아이스 오라");
        this.setDotDuration(720 * 1000L);
        this.setInterval(8000L);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
