package org.mapledpmlab.type.skill.buffskill.cadena;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class WeakPointConvergingAttackBind extends BuffSkill {
    public WeakPointConvergingAttackBind() {
        this.setName("위크포인트 컨버징 어택(바인드)");
        this.setDuration(10L);
        this.addBuffCriticalDamage(11.0);
    }
}
